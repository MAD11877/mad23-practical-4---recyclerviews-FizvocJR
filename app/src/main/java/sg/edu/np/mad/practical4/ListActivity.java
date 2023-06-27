package sg.edu.np.mad.practical4;


import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    final String TAG = "List Activity";
    ArrayList<User> User_list = new ArrayList<>();
    ImageView profile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        for (int i = 0; i < 20; i++) {
            User obj = new User();

            Random randomNum = new Random();
            int ranNum = randomNum.nextInt(999999999);

            Random randomDesc = new Random();
            int ranDesc = randomDesc.nextInt(999999999);

            String Name = "Name" + ranNum;
            String Description = "Description: " + ranDesc;
            obj.setUsername(Name);
            obj.setDescription(Description);
            User_list.add(obj);
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new UserAdatper(User_list, this));
    }
}
