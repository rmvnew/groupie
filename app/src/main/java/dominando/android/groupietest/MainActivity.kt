package dominando.android.groupietest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_main.*

private val groupAdapter = GroupAdapter<GroupieViewHolder>()
private lateinit var groupLayoutManager: LinearLayoutManager

private val childList = listOf(

        ChildItem("First Album"),
        ChildItem("Second Album"),
        ChildItem("Third Album"),
        ChildItem("Fourth Album")

)

private val parentList = listOf(

        ExpandableHeaderItem("Travis Scott"),
        ExpandableHeaderItem("Migos"),
        ExpandableHeaderItem("Post Malone"),
        ExpandableHeaderItem("Drake")

)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        groupLayoutManager = LinearLayoutManager(this)

        xRecyclerView.apply {
            layoutManager = groupLayoutManager
            adapter = groupAdapter
        }


        groupAdapter.apply {
            for (i in parentList){
                this.add(
                        ExpandableGroup(i).apply {
                            for (j  in childList) {
                                add(j)
                            }
                        }
                )

            }
        }



    }



    fun listaAreas():List<InventoryAreaModel>{
        var areaLista = listOf(
                InventoryAreaModel(
                        id = 1,
                        name = "area 51",
                        sector = 0,
                        status = "",
                        parentId = 0,
                        subAreas = listOf(InventoryAreaModel(
                                id = 2,
                                name = "area lab01",
                                sector=0,
                                status = "",
                                parentId = 1,
                                subAreas = listOf(InventoryAreaModel(
                                        id = 3,
                                        name = "area D",
                                        sector=0,
                                        status = "",
                                        parentId = 2,
                                        subAreas = listOf(InventoryAreaModel(
                                                id = 4,
                                                name = "area E",
                                                sector=0,
                                                status = "",
                                                parentId = 2,
                                                subAreas = listOf(InventoryAreaModel(
                                                        id = 5,
                                                        name = "area F",
                                                        sector=0,
                                                        status = "",
                                                        parentId = 2,
                                                        subAreas = listOf()
                                                ))
                                        ))))))
                ), InventoryAreaModel(
                id = 6,
                name = "asfasf",
                sector = 0,
                status = "",
                parentId = 0,
                subAreas = listOf(InventoryAreaModel(
                        id = 5,
                        name = "area sfs",
                        sector=0,
                        status = "",
                        parentId = 4,
                        subAreas = listOf()
                ))
        ), InventoryAreaModel(
                id = 1,
                name = "area doca",
                sector = 0,
                status = "",
                parentId = 0,
                subAreas = listOf(InventoryAreaModel(
                        id = 2,
                        name = "area Takamura",
                        sector=0,
                        status = "",
                        parentId = 1,
                        subAreas = listOf(InventoryAreaModel(
                                id = 3,
                                name = "area E",
                                sector=0,
                                status = "",
                                parentId = 2,
                                subAreas = listOf()
                        ))
                ))
        )
        )
        return areaLista
    }


}