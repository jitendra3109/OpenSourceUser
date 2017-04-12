package in.jsroyal.apiconsume;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import in.jsroyal.apiconsume.controller.DetailActivity;
import in.jsroyal.apiconsume.model.Item;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<Item> items;
    private Context context;

    public ItemAdapter(Context applicationContext, List<Item> itemArrayList) {
        this.context = applicationContext;
        this.items = itemArrayList;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_user, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder viewHolder, int i) {
        viewHolder.title.setText(items.get(i).getLogin());
        viewHolder.githublink1.setText(items.get(i).getHtmlUrl());

        Picasso.with(context)
                .load(items.get(i).getAvatarUrl())
                .placeholder(R.drawable.load)
                .into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, githublink1;
        private ImageView imageView;


        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            githublink1 = (TextView) view.findViewById(R.id.githublink1);
            imageView = (ImageView) view.findViewById(R.id.cover);

            //on item click
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        Item clickedDataItem = items.get(pos);
                        Intent intent = new Intent(context, DetailActivity.class);
                        intent.putExtra("login", items.get(pos).getLogin());
                        intent.putExtra("html_url", items.get(pos).getHtmlUrl());
                        intent.putExtra("avatar_url", items.get(pos).getAvatarUrl());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        Toast.makeText(v.getContext(), "You clicked " + clickedDataItem.getLogin(), Toast.LENGTH_SHORT).show();
                    }
                }

            });
        }
    }
}
