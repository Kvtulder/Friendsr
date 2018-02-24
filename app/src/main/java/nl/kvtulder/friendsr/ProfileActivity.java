package nl.kvtulder.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    SharedPreferences.Editor editor;
    Friend retrievedFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        TextView friendName = findViewById(R.id.friendName);
        friendName.setText(retrievedFriend.getName());

        TextView friendBio = findViewById(R.id.friendBio);
        friendBio.setText(retrievedFriend.getBio());

        ImageView friendImage = findViewById(R.id.friendImage);
        Drawable picture = getResources().getDrawable(retrievedFriend.getDrawableID());
        friendImage.setImageDrawable(picture);

        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        editor = prefs.edit();

        RatingBar ratingBar = findViewById(R.id.friendRating);
        ratingBar.setOnRatingBarChangeListener(new ratingBarClickListener());
        ratingBar.setRating(prefs.getFloat(retrievedFriend.getName() + "Rating",0));
    }

    public class ratingBarClickListener implements RatingBar.OnRatingBarChangeListener
    {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            editor.putFloat(retrievedFriend.getName() + "Rating",ratingBar.getRating());
            editor.apply();
        }
    }

}
