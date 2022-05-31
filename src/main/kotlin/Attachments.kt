interface Attachments {
    val type : String
}

data class PhotoAttachments (
    override val type: String = "photo",
    val photo : Photo
        ) : Attachments

data class VideoAttachments (
    override val type: String = "video",
    val video : Video
) : Attachments

data class AudioAttachments (
    override val type: String = "audio",
    val audio : Audio
) : Attachments

data class DocAttachments (
    override val type: String = "doc",
    val doc : Doc
) : Attachments

data class LinkAttachments (
    override val type: String = "link",
    val link : Link
) : Attachments

data class Photo (
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text : String,
    val date : Int
)

data class Video (
    val id: Int,
    val ownerId: Int,
    val title : String,
    val description : String,
    val date : Int
)

data class Audio (
    val id: Int,
    val ownerId: Int,
    val artist : String,
    val title : String,
    val date: Int
)

data class Doc (
    val id: Int,
    val ownerId: Int,
    val title : String,
    val size : Int,
    val date: Int
)

data class Link (
    val url: String,
    val title : String
)