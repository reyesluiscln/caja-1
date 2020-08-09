package examencoppel.luis.ejercicioheroes.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import examencoppel.luis.ejercicioheroes.R;
import examencoppel.luis.ejercicioheroes.data.Hero;
import examencoppel.luis.ejercicioheroes.view.HeroDetailActivity;
import examencoppel.luis.ejercicioheroes.view.HeroViewHolder;

public class HeroAdapter extends RecyclerView.Adapter<HeroViewHolder> {

    private Context context;
    private List<Hero> heroes;
    private int clickedPosition = RecyclerView.NO_POSITION;

    public HeroAdapter(List<Hero> heroes, Context context){
        this.heroes = heroes;
        this.context = context;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View item = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.activity_main_rows, parent, false);
        return new HeroViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, final int position) {
        holder.setView(heroes.get(position), context);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setClickedPosition(position);
            }
        });
        if (getClickedPosition() > -1){
            Intent intent = new Intent(context, HeroDetailActivity.class);
            intent.putExtra("hero", heroes.get(getClickedPosition()));
            context.startActivity(intent);
        }
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    //Handle clicks on list items
    public int getClickedPosition() {
        return clickedPosition;
    }
    private void setClickedPosition(int pos) {
        notifyItemChanged(clickedPosition);
        clickedPosition = pos;
        notifyItemChanged(clickedPosition);
    }
}
