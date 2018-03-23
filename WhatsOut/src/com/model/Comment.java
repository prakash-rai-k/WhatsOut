package com.model;

import java.time.LocalDateTime;

/*
 *Written on March 19, 2018
 *Model that represents the comments by Users
 *Designed by Yvan GAKUBA and Prakash RAI
 * @Author Rupendra MAHARJAN
 */

public class Comment {
	private int id;
	private String description;
	private LocalDateTime commentAt;
	private WhatsOutUser user;
	private Event event;
	
	public Comment() {
		this.event=new Event();
		this.user=new WhatsOutUser();
	}

	public Comment(int id, String description, LocalDateTime commentAt,WhatsOutUser user, Event event) {
		super();
		this.id = id;
		this.description = description;
		this.commentAt = commentAt;
		this.user=user;
		this.event=event;
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

	public WhatsOutUser getUser() {
		return user;
	}

	public void setUser(WhatsOutUser user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
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
