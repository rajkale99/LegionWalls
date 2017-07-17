/*
 * Copyright (c) 2017. Jahir Fiquitiva
 *
 * Licensed under the CreativeCommons Attribution-ShareAlike
 * 4.0 International License. You may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *    http://creativecommons.org/licenses/by-sa/4.0/legalcode
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jahirfiquitiva.libs.frames.fragments

import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.pluscubed.recyclerfastscroll.RecyclerFastScroller
import jahirfiquitiva.libs.frames.R
import jahirfiquitiva.libs.frames.adapters.CollectionsAdapter
import jahirfiquitiva.libs.frames.extensions.isInHorizontalMode
import jahirfiquitiva.libs.frames.fragments.base.BaseFramesFragment
import jahirfiquitiva.libs.frames.models.Collection
import jahirfiquitiva.libs.kauextensions.ui.views.EmptyViewRecyclerView

class CollectionsFragment:BaseFramesFragment<Collection>() {

    private lateinit var rv:EmptyViewRecyclerView
    private lateinit var adapter:CollectionsAdapter
    private lateinit var fastScroll:RecyclerFastScroller

    override fun initUI(content:View) {
        rv = content.findViewById<EmptyViewRecyclerView>(R.id.list_rv)
        rv.emptyView = content.findViewById(R.id.empty_view)
        rv.textView = content.findViewById(R.id.empty_text)
        rv.emptyTextRes = R.string.empty_section
        rv.loadingView = content.findViewById(R.id.loading_view)
        rv.loadingTextRes = R.string.loading_section
        val spanCount = if (context.isInHorizontalMode) 2 else 1
        rv.layoutManager = GridLayoutManager(context, spanCount,
                                             GridLayoutManager.VERTICAL, false)
        /*
        rv.addItemDecoration(
                GridSpacingItemDecoration(spanCount, context.dimenPixelSize(R.dimen.cards_margin),
                                          true)) */
        adapter = CollectionsAdapter { collection, holder ->
            onCollectionClicked(collection, holder)
        }
        rv.adapter = adapter
        rv.state = EmptyViewRecyclerView.State.LOADING
        fastScroll = content.findViewById(R.id.fast_scroller)
        fastScroll.attachRecyclerView(rv)
    }

    override fun onItemClicked(item:Collection) {
        // Do nothing
    }

    /*
    override fun onCollectionClicked(collection:Collection, img:ImageView, name:TextView) {
        super.onCollectionClicked(collection, img, name)
        // TODO: Open collections activity
    }
    */

    override fun getContentLayout():Int = R.layout.section_lists

    override fun doOnCollectionsChange(data:ArrayList<Collection>) {
        super.doOnCollectionsChange(data)
        if (data.size > 0) {
            adapter.setItems(data)
            rv.state = EmptyViewRecyclerView.State.NORMAL
        }
    }

}