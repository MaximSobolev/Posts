data class Comments (
    val count : Int = 0,
    val canPost : Boolean = true
)

data class Likes(
    val count : Int = 0,
    val userLikes : Boolean = false
)

data class Repost (
    val count : Int = 0,
    val userReposted : Boolean = false
)

data class Views(val count : Int = 0)

data class PostSource(
    val type : String = "vk",
    val platform : String = "android",
    val data : String = "profile_activity",
    val url : String = "0"
)

data class Geo(
    val type: String = "Home",
    val coordinates : String = "0"
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
    val copyright: String?,
    val likes : Likes,
    val repost : Repost?,
    val views : Views,
    val postType : String = "post",
    val postSource : PostSource,
    val geo : Geo?,
    val signerId : Int?,
    val copyHistory : Array<String> = arrayOf(), //должен быть массив
    val canPin : Boolean = true,
    val canDelete : Boolean = true,
    val canEdit : Boolean = true,
    val isPinned : Boolean = false,
    val markedAsAds : Boolean = false,
    val isFavorite : Boolean = false,
    val postponedId : Int = 0
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