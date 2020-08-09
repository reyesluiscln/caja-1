package examencoppel.luis.ejercicioheroes.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import examencoppel.luis.ejercicioheroes.R;
import examencoppel.luis.ejercicioheroes.data.Hero;
import examencoppel.luis.ejercicioheroes.viewmodel.HeroDetail;

public class HeroDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_detail);

        Intent intent = getIntent();
        Hero hero = (Hero) intent.getSerializableExtra("hero");
        HeroDetail viewModel = new HeroDetail(this);
        viewModel.setView(hero);
    }
}
