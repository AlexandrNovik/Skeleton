package skeleton.example.aliak.skeleton.presentation.base

interface ViewModelLifecycle {
    fun initialize()
    fun resume()
    fun pause()
    fun release()
}