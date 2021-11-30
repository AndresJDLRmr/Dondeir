package fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import com.example.adondeirnuevoleon.R
import com.google.firebase.firestore.*
import data.Places
import android.R
import android.widget.ImageView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private val dataset = arrayListOf<Places>()
    private val db = FirebaseFirestore.getInstance()

    /*override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView= inflater.inflate(R.layout., container, false)
        val recyclerView: RecyclerView = rootView.findViewById<RecyclerView>(R.id.placeRecyclerView)
        recyclerView.adapter = PlacesAdapter(recyclerView.context, dataset)
        recyclerView.setHasFixedSize(true)
        return inflater.inflate(R.layout.fragment_home, container, false)

    }
*/
    private fun eventChangeListener() {
        db.collection("lugares").
                addSnapshotListener(object : EventListener<QuerySnapshot>{
                    override fun onEvent(
                        value: QuerySnapshot?,
                        error: FirebaseFirestoreException?
                    ){
                        if (error != null){
                            Log.e("Firestore Error", error.message.toString())
                        }
                        else{
                            for(dc: DocumentChange in value?.documentChanges!!){
                                if (dc.type == DocumentChange.Type.ADDED){
                                    dataset.add(dc.document.toObject(Places::class.java))
                                    Log.d("TAG","$dataset")
                                }
                            }
                        }
                    }
                })
    }


}