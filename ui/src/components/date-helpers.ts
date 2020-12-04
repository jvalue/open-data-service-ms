/**
 * Get the date part of the given date using the browser's local time in ISO format: `YYYY-MM-DD`
 *
 * @example
 * getISODateString(new Date('2020-12-1')) // "2020-12-01"
 */
export const getISODateString = (date: Date): string => {
  const year = `${date.getFullYear()}`
  const months = `0${date.getMonth() + 1}`.replace(/0(\d\d)/, '$1')
  const days = `0${date.getDate()}`.replace(/0(\d\d)/, '$1')

  return `${year}-${months}-${days}`
}

/**
 * Get the time part of the given date using the browser's local time in ISO format: `HH:mm`
 *
 * @example
 * getISOTimeString(new Date('2020-12-1 14:1')) // "14:01"
 */
export const getISOTimeString = (date: Date): string => {
  const hours = `0${date.getHours()}`.replace(/0(\d\d)/, '$1')
  const minutes = `0${date.getMinutes()}`.replace(/0(\d\d)/, '$1')

  return `${hours}:${minutes}`
}
