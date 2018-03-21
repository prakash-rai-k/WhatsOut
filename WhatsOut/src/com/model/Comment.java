package com.model;

import java.time.LocalDateTime;

/**
 *
 * @author Rupendra MAHARJAN
 * Date: 03/19/2018
 * Description: Comment Information
 */

public class Comment {
	private int id;
	private String description;
	private LocalDateTime commentAt;
	
	public Comment() {
		
	}

	public Comment(int id, String description, LocalDateTime commentAt) {
		super();
		this.id = id;
		this.description = description;
		this.commentAt = commentAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCommentAt() {
		return commentAt;
	}

	public void setCommentAt(LocalDateTime commentAt) {
		this.commentAt = commentAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentAt == null) ? 0 : commentAt.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (commentAt == null) {
			if (other.commentAt != null)
				return false;
		} else if (!commentAt.equals(other.commentAt))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", description=" + description + ", commentAt=" + commentAt + "]";
	}
}
