/*
 * Copyright (c) 2018. Jahir Fiquitiva
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
package jahirfiquitiva.libs.frames.ui.adapters

import android.support.v7.widget.RecyclerView
import jahirfiquitiva.libs.archhelpers.ui.adapters.ListAdapter
import jahirfiquitiva.libs.frames.ui.adapters.viewholders.FramesWallpaperHolder
import jahirfiquitiva.libs.frames.ui.adapters.viewholders.GlideSectionedViewHolder

abstract class FramesListAdapter<T, VH : RecyclerView.ViewHolder>(maxLoad: Int = -1) :
        ListAdapter<T, VH>(maxLoad) {
    override fun onViewRecycled(holder: VH) {
        if (holder is FramesWallpaperHolder) holder.onRecycled()
        else if (holder is GlideSectionedViewHolder) holder.onRecycled()
        super.onViewRecycled(holder)
    }
}