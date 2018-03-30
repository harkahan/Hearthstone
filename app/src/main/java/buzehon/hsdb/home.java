package buzehon.hsdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final TextView mTextView = (TextView) findViewById(R.id.text);
        String url ="https://omgvamp-hearthstone-v1.p.mashape.com/cards/search/Soldier";
        Map<String, String> params = new HashMap<>();
        params.put("X-Mashape-Key","G4QZRdLnzbmshGwksVgDYxMD3Y5Wp1doSuEjsnUygl532k6kjB");//put your parameters here
        Custom_Volly_Request jsObjRequest = new Custom_Volly_Request(
                Request.Method.GET, url, params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        mTextView.setText(response.toString());
                        mTextView.setText("test");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError response)
                    {
                        mTextView.setText("Response: Error   /   "+ response.toString());
                    }
                }
        );
    }

}

