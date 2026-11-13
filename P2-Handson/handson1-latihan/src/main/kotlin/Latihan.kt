import kotlinx.coroutines.*

// Hands-on 1: Coroutines Dasar
// Tugas: Ambil data dari 2 sumber secara PARALEL menggunakan async/await,
// lalu gabungkan hasilnya. Total waktu eksekusi harus < 2 detik (bukan ~1800ms
// yang akan terjadi jika dijalankan secara sequential).

suspend fun fetchUserProfile(userId: String): String {
    delay(1000) // Simulasi network delay
    return "User: John Doe"
}

suspend fun fetchUserPosts(userId: String): List<String> {
    delay(800) // Simulasi network delay
    return listOf("Post 1", "Post 2", "Post 3")
}

fun main() = runBlocking {
    // TODO 1: Jalankan fetchUserProfile dan fetchUserPosts secara PARALEL dengan async
    // TODO 2: Tunggu kedua hasil dengan await(), lalu tampilkan dengan println
    // TODO 3: Ukur waktu eksekusi (harus mendekati 1000ms, bukan 1800ms)

    val startTime = System.currentTimeMillis()

    // TODO 1: mulai kedua pekerjaan sekaligus (belum menunggu hasilnya)
    val profileDeferred = async { fetchUserProfile("user-1") }
    val postsDeferred = async { fetchUserPosts("user-1") }

    // TODO 2: baru tunggu hasilnya, lalu gabungkan dan tampilkan
    val profile = profileDeferred.await()
    val posts = postsDeferred.await()
    println(profile)
    println("Posts: $posts")

    val endTime = System.currentTimeMillis()
    println("Waktu: ${endTime - startTime}ms")
}