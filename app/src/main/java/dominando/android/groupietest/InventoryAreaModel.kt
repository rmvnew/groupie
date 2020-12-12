package dominando.android.groupietest

class InventoryAreaModel(
    val subAreas: List<InventoryAreaModel>,
    val id: Int,
    val parentId: Int,
    val sector: Int,
    val status: String,
    val name: String,
    var type:Int = 0
)