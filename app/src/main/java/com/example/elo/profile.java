package com.example.elo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.elo.adapter.eloAdapter;
import com.example.elo.adapter.eloProfileAdapter;
import com.example.elo.adapter.tagAdapter;
import com.example.elo.adapter.typeAdapter;
import com.example.elo.model.EloProfile;
import com.example.elo.model.Elos;
import com.example.elo.model.tagCategory;
import com.example.elo.model.userTypes;

import java.util.ArrayList;
import java.util.List;

public class profile extends AppCompatActivity {

    final Context context = this;
    ImageButton create, home, settingsButton;
    ImageView menu;
    RecyclerView eloRecycler, typeRecycler;
    typeAdapter typeAdapter;
    static eloProfileAdapter eloAdapter;
    static List<EloProfile> eloList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        create = findViewById(R.id.create_elo);
        home = findViewById(R.id.homeButton);
        settingsButton = findViewById(R.id.settingsButton);
        menu = findViewById(R.id.menu);

        List<userTypes> typesList = new ArrayList<>();
        typesList.add(new userTypes(1, "Наставник"));
        typesList.add(new userTypes(2, "Senior"));
        typesList.add(new userTypes(3, "C#"));
        typesList.add(new userTypes(4, "java"));
        typesList.add(new userTypes(5, "sql"));

        setTypesRecycler(typesList);

        eloList.clear();
        eloList.add(new EloProfile(1, "Java для начинающих",
                "Курс Java\nдля Junior-разработчиков",
                "Курс Java для Junior-разработчиков\nОтлично подойдет для развития навыков работы с backend'ом на Java, в первую очередь для работы с сервером",
                "Java для начинающих", 2, "65%"));
        eloList.add(new EloProfile(2, "C# для начинающих",
                "Курс по C#\nдля начинающих разработчиков\n",
                "Этот курс поможет освоить C# так, чтобы быть в нём, как рыба в воде, а также подтянуть знания в области ООП",
                "C# для начинающих", 2, "65%"));
        eloList.add(new EloProfile(3, "SQL for juniors",
                "SQL для самых маленьких\nи не только\n",
                "Азы работы с базами данных, все важные аспекты написания и обработки запросов, особенности работы с PostgreSQL",
                "SQL for juniors", 6, "65%"));

        setEloRecycler(eloList);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, constructor.class);
                startActivity(intent);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(view);
            }
        });
    }

    private void setEloRecycler(List<EloProfile> eloList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        eloRecycler = findViewById(R.id.eloProfileRecycler);
        eloRecycler.setLayoutManager(layoutManager);
        eloAdapter = new eloProfileAdapter(this, eloList);
        eloRecycler.setAdapter(eloAdapter);
    }

    private void setTypesRecycler(List<userTypes> typesList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        typeRecycler = findViewById(R.id.user_tags);
        typeRecycler.setLayoutManager(layoutManager);
        typeAdapter = new typeAdapter(this, typesList);
        typeRecycler.setAdapter(typeAdapter);
    }

    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.inflate(R.menu.popupmenu);

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.menu1)
                        {
                            Intent intent = new Intent(context, auth.class);
                            startActivity(intent);
                            return true;
                        }
                        else
                            return false;
                    }
                });
        popupMenu.show();
    }
}
