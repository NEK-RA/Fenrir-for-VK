package dev.ragnarok.filegallery.materialpopupmenu.builder

import android.widget.CompoundButton
import dev.ragnarok.filegallery.materialpopupmenu.MaterialPopupMenuBuilder
import dev.ragnarok.filegallery.materialpopupmenu.OnShowCallback
import java.util.function.BiConsumer
import java.util.function.Predicate

sealed class ToggleItemBuilder<T : ToggleItemBuilder<T>> : NormalItemBuilder<T>() {
    abstract override val data: MaterialPopupMenuBuilder.ToggleItem.Data
    fun configureToggleComponent(config: BiConsumer<OnShowCallback, CompoundButton>) =
        self().apply { data.config = config }

    fun setToggleCondition(toggleCondition: Predicate<CompoundButton>) =
        self().apply { data.toggleCondition = toggleCondition }

    fun setChecked(checked: Boolean) = self().apply { data.isChecked = checked }
}
