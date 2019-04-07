package m.d.r.d.g.joummah;


import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

public class ParametresFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }
}
