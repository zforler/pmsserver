package com.wk.bean;

import javax.persistence.*;

@Entity
@Table(name = "sys_seq", schema = "pms", catalog = "")
public class SysSeq {
	private String seqKey;
	private Integer nextIndex;

	@Id
	@Column(name = "seq_key", nullable = false, length = 64)
	public String getSeqKey() {
		return seqKey;
	}

	public void setSeqKey(String seqKey) {
		this.seqKey = seqKey;
	}

	@Basic
	@Column(name = "next_index", nullable = true)
	public Integer getNextIndex() {
		return nextIndex;
	}

	public void setNextIndex(Integer nextIndex) {
		this.nextIndex = nextIndex;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SysSeq sysSeq = (SysSeq) o;

		if (seqKey != null ? !seqKey.equals(sysSeq.seqKey) : sysSeq.seqKey != null) return false;
		if (nextIndex != null ? !nextIndex.equals(sysSeq.nextIndex) : sysSeq.nextIndex != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = seqKey != null ? seqKey.hashCode() : 0;
		result = 31 * result + (nextIndex != null ? nextIndex.hashCode() : 0);
		return result;
	}
}
