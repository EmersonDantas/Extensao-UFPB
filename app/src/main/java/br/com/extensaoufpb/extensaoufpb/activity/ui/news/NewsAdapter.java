package br.com.extensaoufpb.extensaoufpb.activity.ui.news;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.extensaoufpb.extensaoufpb.R;
import br.com.extensaoufpb.extensaoufpb.models.bean.News;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private final String TAG = "NewsAdapter";
    private List<News> news;

    public NewsAdapter(List<News> news){
        this.news = news;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.card_news, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(this.news.get(position).getTitle());
        holder.date.setText(this.news.get(position).getDate());
        holder.description.setText(this.news.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return this.news.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView date;
        TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.tvTitle);
            this.date = itemView.findViewById(R.id.tvDate);
            this.description = itemView.findViewById(R.id.tvDescription);
        }
    }
}

