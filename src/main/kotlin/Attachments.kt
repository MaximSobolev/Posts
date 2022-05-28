interface Attachments {
    val type : String
}

data class Photo (
    override val type: String = "photo",
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text : String,
    val date : Int
) : Attachments

data class Video (
    override val type: String = "video",
    val id: Int,
    val ownerId: Int,
    val title : String,
    val description : String,
    val date : Int
) : Attachments

data class Audio (
    override val type: String = "audio",
    val id: Int,
    val ownerId: Int,
    val artist : String,
    val title : String,
    val date: Int
) : Attachments

data class Doc (
    override val type: String = "doc",
    val id: Int,
    val ownerId: Int,
    val title : String,
    val size : Int,
    val date: Int
) : Attachments

data class Link (
    override val type: String = "link",
    val url: String,
    val title : String
) : Attachments