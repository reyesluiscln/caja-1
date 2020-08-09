package examencoppel.luis.ejercicioheroes.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import examencoppel.luis.ejercicioheroes.R;
import examencoppel.luis.ejercicioheroes.data.Hero;

public class HeroViewHolder extends RecyclerView.ViewHolder {

    private ImageView image;
    private TextView id;
    private TextView name;

    public HeroViewHolder(View itemView) {
        super(itemView);
        findViews(itemView);
    }

    private void findViews(View v){
        image = v.findViewById(R.id.image);
        id = v.findViewById(R.id.id);
        name = v.findViewById(R.id.name);
    }

    public void setView(Hero hero, Context context){
        Picasso.get()
                .load(hero.getImage())
                .resize(150, 150)
                .centerCrop()
                .into(image);
        id.setText(hero.getId());
        name.setText(hero.getName());
    }
}