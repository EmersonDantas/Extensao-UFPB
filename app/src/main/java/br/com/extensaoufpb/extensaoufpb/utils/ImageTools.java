package br.com.extensaoufpb.extensaoufpb.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import br.com.extensaoufpb.extensaoufpb.utils.exceptions.ImageCannotConvertToBitmap;

public class ImageTools {

    private static ImageTools instance;

    private ImageTools(){}

    public static ImageTools getInstance(){
        if(instance == null){
            instance = new ImageTools();
        }

        return instance;
    }

    public synchronized Bitmap StringToBitMap(String encodedString) throws ImageCannotConvertToBitmap {
        try{
            byte [] encodeByte = Base64.decode(encodedString,Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        }
        catch(Exception e){
            throw new ImageCannotConvertToBitmap(e.getMessage());
        }
    }

}
