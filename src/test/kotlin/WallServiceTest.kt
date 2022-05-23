import WallService.add
import WallService.edit
import org.junit.Assert.assertEquals
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

        assertEquals(1, 1)
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

        val result = edit(post)

        assertEquals(false, result)
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
        val result = edit(addedPost)

        assertEquals(true, result)
    }
}