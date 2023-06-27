package sg.edu.np.mad.practical4;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class UserAdatper extends RecyclerView.Adapter<UserAdatper.myViewHolder>{

    private Context context;
    private ArrayList<User> userlist;

    public UserAdatper(ArrayList<User> User_list, Context context){
        this.userlist = User_list;
        this.context = context;
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        private ImageView profile;
        private TextView userName;
        private TextView description;
        private ImageView image;

        public myViewHolder(View view) {
            super(view);
            profile = view.findViewById(R.id.ProfileImage);
            image = view.findViewById(R.id.Image);
            userName = view.findViewById(R.id.ProfileName);
            description = view.findViewById(R.id.Description);

            profile.setOnClickListener(parentView -> {
                AlertDialog.Builder builder = new AlertDialog.Builder(parentView.getContext());
                builder.setTitle("Profile");
                builder.setMessage(userName.getText());
                builder.setPositiveButton("View", (dialog, id) -> {
                    // Need to implement the moving to new activity
                    Intent i = new Intent(context, MainActivity.class);
                    i.putExtra("username", userName.getText());
                    i.putExtra("description", description.getText());
                    context.startActivity(i);
                });
                builder.setNegativeButton("Close", (dialog, id) -> dialog.dismiss());
                AlertDialog alert = builder.create();
                alert.show();
            });
        }

        public TextView getUserName() {
            return userName;
        }

        public TextView getDescription() {
            return description;
        }

        public ImageView getImage() {
            return image;
        }
    }

    @Override
    public int getItemViewType(int position) {

        String username = userlist.get(position).getUsername();
        String description = userlist.get(position).getDescription();

        if (username.charAt(username.length() - 1) != '7') {
            return 0;
        }
        return 1;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view;
        if (viewType == 0) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler2, viewGroup, false);
            return new myViewHolder(view);
        }
        if (viewType == 1) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler1, viewGroup, false);
            return new myViewHolder(view);
        }
        return null;
    }

    public void onBindViewHolder(myViewHolder myViewHolder, final int position) {
        String username = userlist.get(position).getUsername();
        String description = userlist.get(position).getDescription();

        myViewHolder.getUserName().setText(username);
        myViewHolder.getDescription().setText(description);
    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

}
