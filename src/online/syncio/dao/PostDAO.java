package online.syncio.dao;

import com.mongodb.client.MongoCollection;
import java.util.List;
import online.syncio.model.Post;

public interface PostDAO extends DAO<Post> {
    public MongoCollection<Post> getAllByCollection();
    public List<Post> getAllByUserID(String userID);
    public boolean addLike(String postID, String userID);
    public boolean removeLike(String postID, String userID);
}
