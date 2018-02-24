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

        // Create an array with default friends, and create the friend objects
        String[] friendNames = {"Angela Moss","Darlene Anderson","Dominique DiPierroe",
                "Elliot Anderson","Philip Price","Mr Robot","Tyrell"};

        // bios copied from the Mr Robot Wikipedia: http://mrrobot.wikia.com/
        int[] friendBios = {R.string.angela,R.string.darlene,R.string.dominique,
                R.string.elliot,R.string.philip,R.string.mrrobot,R.string.tyrell};

        // https://www.sporcle.com/games/braverobot/mr-robot-characters-pic-click
        int[] friendDrawables = {R.drawable.angela,R.drawable.darlene,R.drawable.dominique,
                R.drawable.elliot, R.drawable.philip,R.drawable.mrrobot,R.drawable.tyrell};

        // Add all the friends to the friends arraylist
        for(int i = 0; i < friendDrawables.length; i++) {
            friends.add(new Friend(friendNames[i],getString(friendBios[i]),friendDrawables[i]));
        }

        // Create an adapter for the gridview and display all the friends
        FriendAdapter adapter = new FriendAdapter(this,R.layout.grid_item,friends);
        GridView gridView = findViewById(R.id.GridView);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new GridItemClickListener());
    }

    private class GridItemClickListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            // Picture clicked! Display the corresponding profile
            Friend clickedFriend = (Friend) adapterView.getItemAtPosition(i);
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }


}
