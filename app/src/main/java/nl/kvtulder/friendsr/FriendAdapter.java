package nl.kvtulder.friendsr;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FriendAdapter extends ArrayAdapter<Friend> {
    List<Friend> objects;
    int resource;
    Context context;

    public FriendAdapter(Context context, int resource, List<Friend> objects) {
        super(context, resource, objects);
        this.objects = objects;
        this.resource = resource;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(resource,
                    parent, false);
        }

        Friend friend = objects.get(position);
        ImageView friendImage = convertView.findViewById(R.id.friendImage);
        Drawable picture = context.getResources().getDrawable(friend.getDrawableID());
        friendImage.setImageDrawable(picture);

        TextView friendName = convertView.findViewById(R.id.friendName);
        friendName.setText(friend.getName());



        return convertView;
    }
}
