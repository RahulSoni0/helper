package androidx.core.net;

import android.net.Uri;
import com.itextpdf.text.Annotation;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo18299bv = {1, 0, 3}, mo18300d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\b\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0004H\b¨\u0006\u0005"}, mo18301d2 = {"toFile", "Ljava/io/File;", "Landroid/net/Uri;", "toUri", "", "core-ktx_release"}, mo18302k = 2, mo18303mv = {1, 1, 15})
/* compiled from: Uri.kt */
public final class UriKt {
    public static final Uri toUri(String str) {
        Intrinsics.checkParameterIsNotNull(str, "$this$toUri");
        Uri parse = Uri.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
        return parse;
    }

    public static final Uri toUri(File file) {
        Intrinsics.checkParameterIsNotNull(file, "$this$toUri");
        Uri fromFile = Uri.fromFile(file);
        Intrinsics.checkExpressionValueIsNotNull(fromFile, "Uri.fromFile(this)");
        return fromFile;
    }

    public static final File toFile(Uri uri) {
        Intrinsics.checkParameterIsNotNull(uri, "$this$toFile");
        if (Intrinsics.areEqual((Object) uri.getScheme(), (Object) Annotation.FILE)) {
            return new File(uri.getPath());
        }
        throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + uri).toString());
    }
}
