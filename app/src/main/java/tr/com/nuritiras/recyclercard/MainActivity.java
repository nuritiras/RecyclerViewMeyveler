package tr.com.nuritiras.recyclercard;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import tr.com.nuritiras.recyclercard.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MeyvelerAdapter adapter;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        adapter=new MeyvelerAdapter(Meyveler.getData(),this);

        binding.mainActivityRecyclerView.setHasFixedSize(true);
        LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        binding.mainActivityRecyclerView.setLayoutManager(manager);
        binding.mainActivityRecyclerView.setAdapter(adapter);

        adapter.setOnClickListener(new MeyvelerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Meyveler meyveler, int position) {
                Toast.makeText(getApplicationContext(), meyveler.getMeyveIsmi(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}