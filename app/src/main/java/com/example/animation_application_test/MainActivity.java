package com.example.animation_application_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.nightonke.boommenu.BoomButtons.BoomButton;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.SimpleCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.OnBoomListener;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BoomMenuButton boomMenuButton;
    ListView listView;

    private ArrayList<Pair> piecesAndButtons = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    boomMenuButton = findViewById(R.id.bmb);
    boomMenuButton.setButtonEnum(ButtonEnum.TextOutsideCircle);
    boomMenuButton.setPiecePlaceEnum(PiecePlaceEnum.DOT_5_3);
    boomMenuButton.setButtonPlaceEnum(ButtonPlaceEnum.SC_5_3);
    boomMenuButton.addBuilder(BuilderManager.getTextOutsideCircleButtonBuilder());

    //here setup list view.

        listView = findViewById(R.id.b);

        listView.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1));

        BuilderManager.getCircleButtonData(piecesAndButtons);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                boomMenuButton.setPiecePlaceEnum((PiecePlaceEnum) piecesAndButtons.get(i).first);

                boomMenuButton.setButtonPlaceEnum((ButtonPlaceEnum) piecesAndButtons.get(i).second);

                boomMenuButton.clearBuilders();

                for(int j= 0; j< boomMenuButton.getPiecePlaceEnum().pieceNumber();j++){

                    boomMenuButton.addBuilder(BuilderManager.getTextOutsideCircleButtonBuilder());
                }

            }
        });











    }
}
