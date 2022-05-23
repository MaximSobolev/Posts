data class Comments (
    val count : Int = 0,
    val can_post : Boolean = true,
)

data class Likes(
    val count : Int = 0,
    val user_likes : Boolean = false
)

data class Post(
    val id: Int = 0,
    val owner_id: Int = 0,
    val from_id: Int = 0,
    val created_by : Int = 0,
    val date : Int,
    val text : String,
    val reply_owner_id : Int = 0,
    val reply_post_id : Int = 0,
    val friends_only : Boolean = false,
    val comments : Comments,
    val likes : Likes
)

object WallService {
    private var posts = emptyArray<Post>()

    fun add (post : Post) : Post {
        val postWithId = post.copy(id = posts.size + 1)
        posts += postWithId
        return posts.last()
    }

    fun edit (post : Post) : Boolean {
        for (thisPost in posts) {
            if (post.id == thisPost.id) {
                val editPost = post.copy(from_id = 11, created_by = 11, text = "content")
                add(editPost)
                return true
            }
        }
        return false
    }
}

fun main() {

}