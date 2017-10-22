package uio.androidbootcamp.fragmentsdrawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class DroidDetailsFragment extends Fragment {
    private static final String DROID_ID = "droidId";

    private String droidId;

    public DroidDetailsFragment() {
        // Required empty public constructor
    }

    public static DroidDetailsFragment newInstance(String droidId) {
        DroidDetailsFragment fragment = new DroidDetailsFragment();
        Bundle args = new Bundle();
        args.putString(DROID_ID, droidId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            droidId = getArguments().getString(DROID_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_droid_details, container, false);

        TextView droidNameTextView = view.findViewById(R.id.text_view_droid_name);
        TextView droidDescriptionTextView = view.findViewById(R.id.text_view_droid_description);

        droidNameTextView.setText(getDroidName());
        droidNameTextView.setCompoundDrawablesWithIntrinsicBounds(getDroidImage(), 0, 0, 0);
        droidDescriptionTextView.setText(getDroidDescription());

        return view;
    }

    private Integer getDroidDescription() {
        Map<String, Integer> droidsDescriptions = new HashMap<>();
        droidsDescriptions.put("bb8", R.string.bb8_descripcion);
        droidsDescriptions.put("bb9e", R.string.bb9e_descripcion);
        droidsDescriptions.put("c3po", R.string.c3po_descripcion);
        droidsDescriptions.put("r2d2", R.string.r2d2_descripcion);
        return droidsDescriptions.get(droidId);
    }

    private Integer getDroidImage() {
        Map<String, Integer> droidsImages = new HashMap<>();
        droidsImages.put("bb8", R.drawable.ic_bb8);
        droidsImages.put("bb9e", R.drawable.ic_bb9e);
        droidsImages.put("c3po", R.drawable.ic_c3po);
        droidsImages.put("r2d2", R.drawable.ic_r2d2);
        return droidsImages.get(droidId);
    }

    private Integer getDroidName() {
        Map<String, Integer> droidsNames = new HashMap<>();
        droidsNames.put("bb8", R.string.bb8);
        droidsNames.put("bb9e", R.string.bb9e);
        droidsNames.put("c3po", R.string.c3po);
        droidsNames.put("r2d2", R.string.r2d2);
        return droidsNames.get(droidId);
    }

}
