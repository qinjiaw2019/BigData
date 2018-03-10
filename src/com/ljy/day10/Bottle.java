package com.ljy.day10;

/**
 * 瓶子类，重写equals方法，比较两个瓶子是否相等（只要材质，形状和大小相同，就认为相等）
 * @author Administrator
 *
 */
public class Bottle {
	private String material;
	private String shape;
	private double size;

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Bottle [material=" + material + ", shape=" + shape + ", size=" + size + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Bottle) {
			Bottle b = (Bottle) obj;
			return b.getMaterial().equals(this.material) && b.shape.equals(this.shape) && b.size == this.size;
		}
		return super.equals(obj);
	}

}
