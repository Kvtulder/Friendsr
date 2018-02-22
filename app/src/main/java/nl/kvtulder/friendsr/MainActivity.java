package nl.kvtulder.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Friend> friends = new ArrayList<>();

        String[] friendNames = {"Arya","Cersei","Deanerys","Jamie","Jon","Jorah","Margaery","Melisandre"
                ,"Sansa","Tyrion"};
        int[] friendDrawables = {R.drawable.arya,R.drawable.cersei,R.drawable.daenerys,R.drawable.jaime,
                R.drawable.jon,R.drawable.jorah,R.drawable.margaery,R.drawable.melisandre,
                R.drawable.sansa,R.drawable.tyrion};

        for(int i = 0; i < friendDrawables.length; i++) {
            Log.e("lala","i: " + i);
            friends.add(new Friend(friendNames[i],"",friendDrawables[i]));
        }

        FriendAdapter adapter = new FriendAdapter(this,R.layout.grid_item,friends);
        GridView gridView = findViewById(R.id.GridView);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new GridItemClickListener());
    }

    private class GridItemClickListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            Friend clickedFriend = (Friend) adapterView.getItemAtPosition(i);
            Log.e("laa","Clicked!" + clickedFriend.getName());
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }


}
