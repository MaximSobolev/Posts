import WallService.add
import WallService.update
import org.junit.Assert.*
import org.junit.Test

internal class WallServiceTest {

    @Test
    fun addTest() {
        val comments = Comments()
        val likes = Likes()
        val repost = Repost()
        val views = Views()
        val postSource = PostSource()
        val geo = Geo()


        val post = Post(
            date = 12022012,
            text = "content",
            comments = comments,
            copyright = "netology.ru",
            likes = likes,
            repost = repost,
            views = views,
            postSource = postSource,
            geo = geo,
            signerId = 0
        )

        val result = add(post).id

        assertEquals(1, result)
    }

    @Test
    fun editWithoutExistingId() {
        val comments = Comments()
        val likes = Likes()
        val repost = Repost()
        val views = Views()
        val postSource = PostSource()
        val geo = Geo()

        val post = Post(
            date = 12022012,
            text = "content",
            comments = comments,
            copyright = "netology.ru",
            likes = likes,
            repost = repost,
            views = views,
            postSource = postSource,
            geo = geo,
            signerId = 0
        )

        val result = update(post)

        assertFalse(result)
    }

    @Test
    fun editWithExistingId() {
        val comments = Comments()
        val likes = Likes()
        val repost = Repost()
        val views = Views()
        val postSource = PostSource()
        val geo = Geo()

        val post = Post(
            date = 12022012,
            text = "content",
            comments = comments,
            copyright = "netology.ru",
            likes = likes,
            repost = repost,
            views = views,
            postSource = postSource,
            geo = geo,
            signerId = 0
        )

        val addedPost = add(post)
        val result = update(addedPost)

        assertTrue(result)
    }
}