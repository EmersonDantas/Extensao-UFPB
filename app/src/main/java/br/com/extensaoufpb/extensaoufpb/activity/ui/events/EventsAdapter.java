package br.com.extensaoufpb.extensaoufpb.activity.ui.events;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.models.bean.Event;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {

    private final String TAG = "EventsAdapter";
    private List<Event> events;

    public EventsAdapter(List<Event> events){
        this.events = events;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.card_events, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.image.setImageResource(this.events.get(position).getImage());
        holder.title.setText(this.events.get(position).getTitle());
        holder.desciption.setText(this.events.get(position).getDesciption());
        holder.data.setText(this.events.get(position).getData());
        holder.duration.setText(this.events.get(position).getDuration());
        holder.locate.setText(this.events.get(position).getLocate());
        holder.room.setText(this.events.get(position).getRoom());
        holder.cHorary.setText(this.events.get(position).getcHorary());
        holder.certify.setText(this.events.get(position).isCertify() ? "Gera certificado de participação" : "Não gera certificado de participação");
    }

    @Override
    public int getItemCount() {
        return this.events.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        TextView desciption;
        TextView data;
        TextView duration;
        TextView locate;
        TextView room;
        TextView cHorary;
        TextView certify;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.eventImage);
            title = itemView.findViewById(R.id.tvTitle);
            desciption = itemView.findViewById(R.id.tvDescription);
            data = itemView.findViewById(R.id.tvDate);
            duration = itemView.findViewById(R.id.tvDuration);
            locate = itemView.findViewById(R.id.tvLocation);
            room = itemView.findViewById(R.id.tvRoom);
            cHorary = itemView.findViewById(R.id.tvHorary);
            certify = itemView.findViewById(R.id.tvCertify);
        }
    }
}

