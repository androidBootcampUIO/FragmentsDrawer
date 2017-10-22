package uio.androidbootcamp.fragmentsdrawer;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class StarWarsFragment extends Fragment {
    private OnStarWarsFragmentInteractionListener mListener;

    public StarWarsFragment() {
        // Required empty public constructor
    }

    public static StarWarsFragment newInstance() {
        return new StarWarsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_star_wars, container, false);

        TextView bb8TextView = view.findViewById(R.id.text_view_bb8);
        TextView bb9eTextView = view.findViewById(R.id.text_view_bb9e);
        TextView c3poTextView = view.findViewById(R.id.text_view_c3po);
        TextView r2d2TextView = view.findViewById(R.id.text_view_r2d2);

        setOnClick(bb8TextView, "bb8");
        setOnClick(bb9eTextView, "bb9e");
        setOnClick(c3poTextView, "c3po");
        setOnClick(r2d2TextView, "r2d2");

        return view;
    }

    private void setOnClick(TextView textView, final String droid) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDroidClicked(droid);
            }
        });
    }

    public void onDroidClicked(String droid) {
        if (mListener != null) {
            mListener.onDroidClicked(droid);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnStarWarsFragmentInteractionListener) {
            mListener = (OnStarWarsFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnStarWarsFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnStarWarsFragmentInteractionListener {
        void onDroidClicked(String droid);
    }
}
