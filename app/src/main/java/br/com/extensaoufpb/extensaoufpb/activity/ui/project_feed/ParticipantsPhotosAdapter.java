package br.com.extensaoufpb.extensaoufpb.activity.ui.project_feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.models.bean.Extensionist;

public class ParticipantsPhotosAdapter extends RecyclerView.Adapter<ParticipantsPhotosAdapter.ViewHolder> {

    private final String TAG = "ParticipantsPhotosAdapter";
    private List<Extensionist> participants;

    public ParticipantsPhotosAdapter(List<Extensionist> participants){
        this.participants = participants;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.card_participants_photos, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // To use in production
//        try {
//            holder.participant_photo.setImageBitmap(ImageTools.getInstance().StringToBitMap(this.participants.get(position).getImage()));
//        } catch (ImageCannotConvertToBitmap e) {
//            System.out.println(e.getMessage());
//        }
        holder.participant_photo.setImageResource(this.participants.get(position).getProfilePhoto());
    }

    @Override
    public int getItemCount() {
        return this.participants.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView participant_photo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.participant_photo = itemView.findViewById(R.id.participant_photo);
        }
    }
}

