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
        val audio = AudioAttachments (
            id = 1,
            ownerId = 1,
            artist = "Artist",
            title = "title",
            date = 22082021)
        val photo = PhotoAttachments (
            id = 2,
            albumId = 2,
            ownerId = 2,
            userId = 2,
            text = "content",
            date  = 22082021)


        val post = Post(
            date = 12022012,
            text = "content",
            comments = comments,
            copyright = "netology.ru",
            likes = likes,
            repost = repost,
            views = views,
            postSource = postSource,
            attachments = arrayOf(audio, photo),
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
        val audio = AudioAttachments (
            id = 1,
            ownerId = 1,
            artist = "Artist",
            title = "title",
            date = 22082021)
        val photo = PhotoAttachments (
            id = 2,
            albumId = 2,
            ownerId = 2,
            userId = 2,
            text = "content",
            date  = 22082021)

        val post = Post(
            date = 12022012,
            text = "content",
            comments = comments,
            copyright = "netology.ru",
            likes = likes,
            repost = repost,
            views = views,
            postSource = postSource,
            attachments = arrayOf(audio, photo),
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
        val audio = AudioAttachments (
            id = 1,
            ownerId = 1,
            artist = "Artist",
            title = "title",
            date = 22082021)
        val photo = PhotoAttachments (
            id = 2,
            albumId = 2,
            ownerId = 2,
            userId = 2,
            text = "content",
            date  = 22082021)

        val post = Post(
            date = 12022012,
            text = "content",
            comments = comments,
            copyright = "netology.ru",
            likes = likes,
            repost = repost,
            views = views,
            postSource = postSource,
            attachments = arrayOf(audio, photo),
            geo = geo,
            signerId = 0
        )

        val addedPost = add(post)
        val result = update(addedPost)

        assertTrue(result)
    }
}