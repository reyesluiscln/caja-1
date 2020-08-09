package examencoppel.luis.ejercicioheroes.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import examencoppel.luis.ejercicioheroes.R;
import examencoppel.luis.ejercicioheroes.api.HeroApiAccess;
import examencoppel.luis.ejercicioheroes.viewmodel.HeroAdapter;

public class MainActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HeroApiAccess apiAccess = new HeroApiAccess(this);

        RecyclerView heroRecycler = findViewById(R.id.heroRecylerView);
        HeroAdapter heroAdapter = new HeroAdapter(apiAccess.getHeroes(),this);
        apiAccess.setHeroAdapter(heroAdapter);
        heroRecycler.setAdapter(heroAdapter);
        heroRecycler.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        heroRecycler.setLayoutManager(llm);

        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(heroRecycler.getContext(),
                        llm.getOrientation());
        heroRecycler.addItemDecoration(dividerItemDecoration);
    }


}
