package dominando.android.groupietest

import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_list_parent.view.*

class ExpandableHeaderItem(val title: String) : Item() , ExpandableItem {
    private lateinit var expandableGroup: ExpandableGroup

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

        viewHolder.root.parent_text_title.text = title
        viewHolder.itemView.setOnClickListener {
            expandableGroup.onToggleExpanded()
            changeStuff(viewHolder)
        }

    }

    override fun getLayout(): Int {
        return  R.layout.item_list_parent
    }

    private fun changeStuff(viewHolder: GroupieViewHolder) {

        viewHolder.root.indicator.apply {
            setImageResource(
                if (expandableGroup.isExpanded) R.drawable.ic_baseline_arrow_drop_up_24
                else R.drawable.ic_baseline_keyboard_arrow_down_24)
        }

    }

    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
        this.expandableGroup = onToggleListener
    }


}