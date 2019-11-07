package test.com.a61pcorrect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        status = findViewById(R.id.status);
    }

    public void onClick(View view) {
        new task().execute();
    }

    class task extends AsyncTask<Void,Integer,Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                for(int i = 3;i>=0;i--) {
                    Thread.sleep(1000);
                    publishProgress(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
                status.setText(Integer.toString(values[0]));
        }
    }
}


