package nl.kvtulder.friendsr;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        TextView friendName = findViewById(R.id.friendName);
        friendName.setText(retrievedFriend.getName());

        ImageView friendImage = findViewById(R.id.friendImage);
        Drawable picture = getResources().getDrawable(retrievedFriend.getDrawableID());
        friendImage.setImageDrawable(picture);
    }
}
