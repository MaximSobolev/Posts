import WallService.add
import WallService.update
import org.junit.Assert.*
import org.junit.Test

internal class WallServiceTest {

    @Test
    fun addTest() {
        val comments = Comments()
        val likes = Likes()
        val post = Post(
            date = 12022012,
            text = "content",
            comments = comments,
            likes = likes
        )

        val result = add(post).id

        assertEquals(1, result)
    }

    @Test
    fun editWithoutExistingId() {
        val comments = Comments()
        val likes = Likes()
        val post = Post(
            date = 12022012,
            text = "content",
            comments = comments,
            likes = likes
        )

        val result = update(post)

        assertFalse(result)
    }

    @Test
    fun editWithExistingId() {
        val comments = Comments()
        val likes = Likes()
        val post = Post(
            date = 12022012,
            text = "content",
            comments = comments,
            likes = likes
        )

        val addedPost = add(post)
        val result = update(addedPost)

        assertTrue(result)
    }
}