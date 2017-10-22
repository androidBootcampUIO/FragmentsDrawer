package uio.androidbootcamp.fragmentsdrawer;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class PokemonFragment extends Fragment {
    private OnPokemonFragmentInteractionListener mListener;

    public PokemonFragment() {
        // Required empty public constructor
    }

    public static PokemonFragment newInstance() {
        return new PokemonFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokemon, container, false);

        TextView bulbasaurTextView = view.findViewById(R.id.text_view_bulbasaur);
        TextView charmanderTextView = view.findViewById(R.id.text_view_charmander);
        TextView pikachuTextView = view.findViewById(R.id.text_view_pikachu);
        TextView squirtleTextView = view.findViewById(R.id.text_view_squirtle);

        setOnClick(bulbasaurTextView, "bulbasaur");
        setOnClick(charmanderTextView, "charmander");
        setOnClick(pikachuTextView, "pikachu");
        setOnClick(squirtleTextView, "squirtle");

        return view;
    }

    private void setOnClick(TextView textView, final String pokemon) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPokemonClicked(pokemon);
            }
        });
    }

    public void onPokemonClicked(String pokemon) {
        if (mListener != null) {
            mListener.onPokemonClicked(pokemon);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnPokemonFragmentInteractionListener) {
            mListener = (OnPokemonFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnPokemonFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnPokemonFragmentInteractionListener {
        void onPokemonClicked(String pokemon);
    }
}
