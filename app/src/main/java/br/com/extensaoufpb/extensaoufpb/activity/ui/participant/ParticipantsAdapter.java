package br.com.extensaoufpb.extensaoufpb.activity.ui.participant;

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
import br.com.extensaoufpb.extensaoufpb.utils.ImageTools;
import br.com.extensaoufpb.extensaoufpb.utils.exceptions.ImageCannotConvertToBitmap;
import de.hdodenhof.circleimageview.CircleImageView;

public class ParticipantsAdapter extends RecyclerView.Adapter<ParticipantsAdapter.ViewHolder> {

    private final String TAG = "ParticipantsAdapter";
    private List<Extensionist> participants;

    public ParticipantsAdapter(List<Extensionist> participants){
        this.participants = participants;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.card_participants, parent, false);
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
        holder.participant_name.setText(this.participants.get(position).getName());
        holder.participant_course.setText(this.participants.get(position).getCourse());
        holder.participant_state.setText(this.participants.get(position).getState());
    }

    @Override
    public int getItemCount() {
        return this.participants.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView participant_photo;
        TextView participant_name;
        TextView participant_course;
        TextView participant_state;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.participant_photo = itemView.findViewById(R.id.participant_photo);
            this.participant_name = itemView.findViewById(R.id.tVparticipantName);
            this.participant_course = itemView.findViewById(R.id.tvParticipantCourse);
            this.participant_state = itemView.findViewById(R.id.tvParticipantState);
        }
    }
}

