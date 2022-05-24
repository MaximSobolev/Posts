data class Comments (
    val count : Int = 0,
    val canPost : Boolean = true,
)

data class Likes(
    val count : Int = 0,
    val userLikes : Boolean = false
)

data class Post(
    val id: Int = 0,
    val ownerId: Int = 0,
    val fromId: Int = 0,
    val createdBy : Int = 0,
    val date : Int,
    val text : String,
    val replyOwnerId : Int = 0,
    val replyPostId : Int = 0,
    val friendsOnly : Boolean = false,
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

    fun update (post : Post) : Boolean {
        for ((index, oldPost) in posts.withIndex()) {
            if (post.id == oldPost.id) {
                posts[index] = post.copy(ownerId = oldPost.ownerId, date = oldPost.date)
                return true
            }
        }
        return false
    }
}

fun main() {

}