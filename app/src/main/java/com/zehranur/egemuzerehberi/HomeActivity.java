package com.zehranur.egemuzerehberi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import com.zehranur.egemuzerehberi.R;

public class HomeActivity extends AppCompatActivity {

    Button btnLogout;
    RecyclerView recyclerView;
    MuseumAdapter adapter;
    List<Museum> museumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.zehranur.egemuzerehberi.R.layout.activity_home);

        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        museumList = new ArrayList<>();
        populateMuseumList();

        recyclerView = findViewById(R.id.recyclerViewMuseums);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MuseumAdapter(museumList, new MuseumAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Museum clickedMuseum) {
                Intent intent = new Intent(HomeActivity.this, DetailActivity.class);
                intent.putExtra("MUSEUM_NAME", clickedMuseum.getName());
                intent.putExtra("MUSEUM_IMAGE", clickedMuseum.getImageResId());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);


        // Android'e, bu sayfadaki RecyclerView elemanlarına uzun basıldığında menüyü yakalamasını söyler.
        registerForContextMenu(recyclerView);

        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });
    }

    private void filter(String text) {
        List<Museum> filteredList = new ArrayList<>();
        for (Museum item : museumList) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList);
    }

    private void populateMuseumList() {
        museumList.add(new Museum("Efes Müzesi", "Selçuk, İzmir", R.drawable.efes_muzesi));
        museumList.add(new Museum("Bergama Müzesi", "Bergama, İzmir", R.drawable.bergama_muzesi));
        museumList.add(new Museum("Agora Ören Yeri", "Konak, İzmir", R.drawable.agora_oren_yeri));
        museumList.add(new Museum("İzmir Arkeoloji Müzesi", "Konak, İzmir", R.drawable.izmir_arkeoloji));
        museumList.add(new Museum("Çeşme Kalesi Müzesi", "Çeşme, İzmir", R.drawable.cesme_kalesi));

        museumList.add(new Museum("Bodrum Sualtı Arkeoloji", "Bodrum, Muğla", R.drawable.bodrum_sualti));
        museumList.add(new Museum("Knidos Antik Kenti", "Datça, Muğla", R.drawable.knidos_antik));
        museumList.add(new Museum("Zeki Müren Sanat Müzesi", "Bodrum, Muğla", R.drawable.zeki_muren));
        museumList.add(new Museum("Marmaris Kalesi Müzesi", "Marmaris, Muğla", R.drawable.marmaris_kalesi));

        museumList.add(new Museum("Aphrodisias Müzesi", "Karacasu, Aydın", R.drawable.aphrodisias));
        museumList.add(new Museum("Milet Müzesi", "Didim, Aydın", R.drawable.milet_muzesi));
        museumList.add(new Museum("Apollon Tapınağı", "Didim, Aydın", R.drawable.apollon_tapinagi));

        museumList.add(new Museum("Hierapolis Arkeoloji", "Pamukkale, Denizli", R.drawable.hierapolis));
        museumList.add(new Museum("Laodikeia Antik Kenti", "Merkez, Denizli", R.drawable.laodikeia_antik));
        museumList.add(new Museum("Sardes Antik Kenti", "Salihli, Manisa", R.drawable.sardes_antik));
    }
}