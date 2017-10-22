package uio.androidbootcamp.fragmentsdrawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class ItemDetailsFragment extends Fragment {
    private static final String ITEM_ID = "itemId";
    private static final String DRAWER_ID = "drawerId";

    private String itemId;
    private int drawerId;

    public ItemDetailsFragment() {
        // Required empty public constructor
    }

    public static ItemDetailsFragment newInstance(String itemId, int drawerId) {
        ItemDetailsFragment fragment = new ItemDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ITEM_ID, itemId);
        args.putInt(DRAWER_ID, drawerId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            itemId = getArguments().getString(ITEM_ID);
            drawerId = getArguments().getInt(DRAWER_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_details, container, false);

        TextView itemNameTextView = view.findViewById(R.id.text_view_item_name);
        TextView droidDescriptionTextView = view.findViewById(R.id.text_view_item_description);

        itemNameTextView.setText(getName());
        itemNameTextView.setCompoundDrawablesWithIntrinsicBounds(geImage(), 0, 0, 0);
        droidDescriptionTextView.setText(getDescription());

        return view;
    }

    private Integer getDescription() {
        Map<String, Integer> droidsDescriptions = new HashMap<>();
        droidsDescriptions.put("bb8", R.string.bb8_descripcion);
        droidsDescriptions.put("bb9e", R.string.bb9e_descripcion);
        droidsDescriptions.put("c3po", R.string.c3po_descripcion);
        droidsDescriptions.put("r2d2", R.string.r2d2_descripcion);

        droidsDescriptions.put("bulbasaur", R.string.bulbasaur_descripcion);
        droidsDescriptions.put("charmander", R.string.charmander_descripcion);
        droidsDescriptions.put("pikachu", R.string.pikachu_descripcion);
        droidsDescriptions.put("squirtle", R.string.squirtle_descripcion);
        return droidsDescriptions.get(itemId);
    }

    private Integer geImage() {
        Map<String, Integer> droidsImages = new HashMap<>();
        droidsImages.put("bb8", R.drawable.ic_bb8);
        droidsImages.put("bb9e", R.drawable.ic_bb9e);
        droidsImages.put("c3po", R.drawable.ic_c3po);
        droidsImages.put("r2d2", R.drawable.ic_r2d2);

        droidsImages.put("bulbasaur", R.drawable.ic_bulbasaur);
        droidsImages.put("charmander", R.drawable.ic_charmander);
        droidsImages.put("pikachu", R.drawable.ic_pikachu);
        droidsImages.put("squirtle", R.drawable.ic_squirtle);
        return droidsImages.get(itemId);
    }

    private Integer getName() {
        Map<String, Integer> droidsNames = new HashMap<>();
        droidsNames.put("bb8", R.string.bb8);
        droidsNames.put("bb9e", R.string.bb9e);
        droidsNames.put("c3po", R.string.c3po);
        droidsNames.put("r2d2", R.string.r2d2);

        droidsNames.put("bulbasaur", R.string.bulbasaur);
        droidsNames.put("charmander", R.string.charmander);
        droidsNames.put("pikachu", R.string.pikachu);
        droidsNames.put("squirtle", R.string.squirtle);
        return droidsNames.get(itemId);
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity activity = (MainActivity) getActivity();
        activity.setSelectedDrawerItem(drawerId);
    }

}
