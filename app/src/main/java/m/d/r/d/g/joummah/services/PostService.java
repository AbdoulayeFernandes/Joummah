package m.d.r.d.g.joummah.services;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PostService extends AsyncTask<Void, Void, String> {

    private String urlRecuperationInfoPost = "https://joummah.com/API/Blogservice.php";


    @Override
    protected String doInBackground(Void... voids) {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(urlRecuperationInfoPost).build();
        try {
            Response response = client.newCall(request).execute();

            if (response.code()==200){
                Log.i("chargement ok","chargement ok");
                return response.body().string();
            }
            else {
                Log.e("erreur chargement", "code erreur : "+response.code());
                return null;
            }

        } catch (IOException e) {
            return null;
        }

    }
}
