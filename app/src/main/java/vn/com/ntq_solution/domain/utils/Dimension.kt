package vn.com.ntq_solution.domain.utils

import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue

/** Android dimension calculator utilities. */
class Dimension {
    companion object {
        /**
         * Converts dip into its equivalent px.
         *
         * @param px The parse request number in pixel.
         * @return The parsed result in dip base on current device density.
         */
        fun pxToDp(px: Float): Int {
            val metrics = DisplayMetrics()
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, metrics).toInt()
        }

        /**
         * Converts px into its equivalent dip.
         *
         * @param dp The parse request number in dip.
         * @return The parsed result in pixel base on current device density.
         */
        fun dpToPx(dp: Int): Float {
            return dp * Resources.getSystem().displayMetrics.density
        }
    }
}
